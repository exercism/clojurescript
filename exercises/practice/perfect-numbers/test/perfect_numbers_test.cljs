(ns perfect-numbers-test
  (:require
   [cljs.test :refer [deftest is testing] :as t :include-macros true]
   [perfect-numbers]))

(deftest test-initialize-perfect-number
  (testing "Negative numbers throw an exception"
    (is (thrown? js/Error (perfect-numbers/classify -1)))))

(deftest test-classify-deficient
  (testing "13 is a deficient number"
    (is (= :deficient (perfect-numbers/classify 13)))))

(deftest test-classify-perfect
  (testing "28 is a perfect number"
    (is (= :perfect (perfect-numbers/classify 28)))))

(deftest test-classify-abundant
  (testing "12 is an abundant number"
    (is (= :abundant (perfect-numbers/classify 12)))))
