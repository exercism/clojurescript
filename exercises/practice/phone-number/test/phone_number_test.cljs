(ns phone-number-test
  (:require phone-number
            [cljs.test :refer [deftest testing is] :as t :include-macros true]))

(deftest cleans-the-number
  (is (= "2234567890" (phone-number/number "(223) 456-7890"))))

(deftest cleans-numbers-with-dots
  (is (= "2234567890" (phone-number/number "223.456.7890"))))

(deftest cleans-numbers-with-multiple-spaces
  (is (= "2234567890" (phone-number/number "223 456   7890   "))))

(deftest invalid-when-9-digits
  (is (= "0000000000" (phone-number/number "123456789"))))

(deftest invalid-when-11-digits-does-not-start-with-a-1
  (is (= "0000000000" (phone-number/number "22234567890"))))

(deftest valid-when-11-digits-and-starting-with-1
  (is (= "2234567890" (phone-number/number "12234567890"))))

(deftest valid-when-11-digits-and-starting-with-1-even-with-punctuation
  (is (= "2234567890" (phone-number/number "+1 (223) 456-7890"))))

(deftest invalid-when-more-than-11-digits
  (is (= "0000000000" (phone-number/number "321234567890"))))

(deftest invalid-with-letters-1
  (is (= "0000000000" (phone-number/number "123-abc-7890"))))

(deftest invalid-with-letters-2
  (is (= "0000000000" (phone-number/number "523-abc-7890"))))

(deftest invalid-with-punctuations-1
  (is (= "0000000000" (phone-number/number "123-@:!-7890"))))

(deftest invalid-with-punctuations-2
  (is (= "0000000000" (phone-number/number "523-@:!-7890"))))

(deftest invalid-if-area-code-starts-with-0
  (is (= "0000000000" (phone-number/number "(023) 456-7890"))))

(deftest invalid-if-area-code-starts-with-1
  (is (= "0000000000" (phone-number/number "(123) 456-7890"))))

(deftest invalid-if-exchange-code-starts-with-0-on-valid-11-digit-number
  (is (= "0000000000" (phone-number/number "1 (223) 056-7890"))))

(deftest invalid-if-exchange-code-starts-with-1-on-valid-11-digit-number
  (is (= "0000000000" (phone-number/number "1 (223) 156-7890"))))

(deftest area-code
  (is (= "223" (phone-number/area-code "2234567890"))))

(deftest area-code-with-dots
  (is (= "555" (phone-number/area-code "555.867.5309"))))

(deftest area-code-with-parentheses
  (is (= "987" (phone-number/area-code "(987) 654-3210"))))

(deftest area-code-with-full-us-phone-number
  (is (= "223" (phone-number/area-code "12234567890"))))

(deftest pretty-print
  (is (= "(223) 456-7890" (phone-number/pretty-print "2234567890"))))

(deftest pretty-print-with-dots
  (is (= "(555) 867-5309" (phone-number/pretty-print "555.867.5309"))))

(deftest pretty-print-with-full-us-phone-number
  (is (= "(987) 654-3210" (phone-number/pretty-print "19876543210"))))
