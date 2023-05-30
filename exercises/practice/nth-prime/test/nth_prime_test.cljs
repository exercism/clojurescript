(ns nth-prime-test
  (:require [cljs.test :refer [deftest is testing] :as t :include-macros true]
            nth-prime))

(deftest first-prime
  (testing "the first prime is 2"
    (is (= 2 (nth-prime/nth-prime 1)))))

(deftest second-prime
  (testing "the second prime is 3"
    (is (= 3 (nth-prime/nth-prime 2)))))

(deftest sixth-prime
  (testing "the sixth prime is 13"
    (is (= 13 (nth-prime/nth-prime 6)))))

(deftest ten-thousand-first-prime
  (testing "the ten thousand and first prime is 104743"
    (is (= 104743 (nth-prime/nth-prime 10001)))))

(deftest zeroth-prime
  (testing "there is no zeroth prime"
    (is (thrown? js/Error (nth-prime/nth-prime 0)))))
