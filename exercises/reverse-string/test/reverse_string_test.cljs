(ns reverse-string-test
  (:require [reverse-string]
            [cljs.test :as t :include-macros true]))

(t/deftest empty-reverse-string-test
  (t/testing "Reverse String empty test..."
    (let [empty-test-result ""
          empty-test-argument ""]
      (t/is (= (reverse-string/reverse-string empty-test-argument)
               empty-test-result)))))

(t/deftest a-letter-reverse-string-test
  (t/testing "Reverse String a letter test..."
    (let [letter-test-result "S"
          letter-test-argument "S"]
      (t/is (= (reverse-string/reverse-string letter-test-argument)
               letter-test-result)))))

(t/deftest a-word-reverse-string-test
  (t/testing "Reverse String a word test..."
    (let [a-word-test-result "tpircserujolc"
          a-word-test-argument "clojurescript"]
      (t/is (= "tobor" (reverse-string/reverse-string "robot"))))))

(t/deftest capitalised-words-reverse-string-test
  (t/testing "Reverse String a word test..."
    (let [word-test-results ["hannaH" "haraS" "lameK"]
          word-test-arguments ["Hannah" "Sarah" "Kemal"]]
      (t/is (= (map reverse-string/reverse-string word-test-arguments)
               word-test-results)))))

(t/deftest long-string-test
  (let [s (reduce str (repeat 1000 "overflow?"))
        rs (reduce str (repeat 1000 "?wolfrevo"))]
    (t/is (= rs (reverse-string/reverse-string s)))))
