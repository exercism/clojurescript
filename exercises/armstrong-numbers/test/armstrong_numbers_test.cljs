(ns armstrong-numbers-test
  (:require [armstrong-numbers]
            [cljs.test :as t :include-macros true]))

(t/deftest armstrong-number-0
  (t/testing "Zero is an Armstrong number..."
    (t/is (armstrong-numbers/armstrong? 0))))

(t/deftest armstrong-number-5
  (t/testing "Single digit numbers are Armstrong numbers..."
    (t/is (armstrong-numbers/armstrong? 5))))

(t/deftest not-armstrong-number-10
  (t/testing "There are no 2 digit Armstrong numbers..."
    (t/is (not (armstrong-numbers/armstrong? 10)))))

(t/deftest armstrong-number-153
  (t/testing "Three digit number that is an Armstrong number..."
    (t/is (armstrong-numbers/armstrong? 153))))

(t/deftest not-armstrong-number-100
  (t/testing "Three digit number that is not an Armstrong number..."
    (t/is (not (armstrong-numbers/armstrong? 100)))))

(t/deftest armstrong-number-9474
  (t/testing "Four digit number that is an Armstrong number..."
    (t/is (armstrong-numbers/armstrong? 9474))))

(t/deftest not-armstrong-number-9475
  (t/testing "Four digit number that is not an Armstrong number..."
    (t/is (not (armstrong-numbers/armstrong? 9475)))))

(t/deftest armstrong-number-9926315
  (t/testing "Seven digit number that is an Armstrong number..."
    (t/is (armstrong-numbers/armstrong? 9926315))))

(t/deftest not-armstrong-number-9926314
  (t/testing "Seven digit number that is not an Armstrong number..."
    (t/is (not (armstrong-numbers/armstrong? 9926314)))))

(t/deftest armstrong-number-21897142587612075
  (t/testing "Seventeen digit number that is an Armstrong number..."
    (t/is (not (armstrong-numbers/armstrong? 21897142587612075)))))
