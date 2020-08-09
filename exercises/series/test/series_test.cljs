(ns series-test
  (:require [series :refer [slices]]
            [cljs.test :refer [deftest is testing] :as t :include-macros true]))

(deftest empty-string
  (testing "empty string with any number"
    (is (= [] (slices "" 1)))))

(deftest number-eq-zero
  (testing "number = 0"
    (is (= [""] (slices "123" 0)))))

(deftest number>string
  (testing "number > string-length"
    (is (= [] (slices "123" 1000)))))

(deftest number=string
  (testing "number = string-length"
    (is (= ["123"] (slices "123" 3)))))

(deftest number<string
  (testing "number < string-length"
    (is (= #{"123" "234" "345"} (set (slices "12345" 3))))))
