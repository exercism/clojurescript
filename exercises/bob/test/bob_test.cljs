(ns bob-test
  (:require [bob]
            [cljs.test :as t :include-macros true]))

(t/deftest bob-responds-to-something
  (t/testing "Bob responds to something..."
    (let [bob-test-result "Whatever."]
      (t/is (= (bob/response-for "Tom-ay-to, tom-aaaah-to.")
               bob-test-result)))))

(t/deftest bob-responds-to-shouts
  (t/testing "Bob responds to shouts and gibberish..!"
    (let [bob-test-result "Whoa, chill out!"]
      (t/is (= (bob/response-for "WATCH OUT!")
               bob-test-result))
      (t/is (= (bob/response-for "FCECDFCAAB!")
               bob-test-result)))))

(t/deftest bob-responds-to-questions
  (t/testing "Bob responds to questions..."
    (t/is (= (bob/response-for "Does this cryogenic chamber make me look fat?")
             "Sure."))
    (t/is (= (bob/response-for "You are, what, like 15?")
             "Sure."))
    (t/is (= (bob/response-for "fffbbcbeab?")
             "Sure."))))

(t/deftest bob-responds-to-forceful-talking
  (t/testing "Bob responds to forceful talking..."
    (t/is (= (bob/response-for "Let's go make out behind the gym!")
             "Whatever."))))

(t/deftest bob-responds-to-acronyms
  (t/testing "Bob responds to acronyms..."
    (t/is (= (bob/response-for "It's OK if you don't want to go to the DMV.")
             "Whatever."))))

(t/deftest bob-responds-to-shouting-numbers
  (t/testing "Bob responds to shouting numbers..."
    (t/is (= (bob/response-for "1, 2, 3 GO!")
             "Whoa, chill out!"))))

(t/deftest bob-responds-to-no-letters
  (t/testing "Bob responds to no letters..."
    (t/is (= (bob/response-for "4?")
             "Sure."))
    (t/is (= (bob/response-for "1, 2, 3")
             "Whatever."))))

(t/deftest bob-responds-to-shouting-with-special-characters
  (t/testing "Bob responds to shouting with special characters..."
    (t/is (= (bob/response-for "ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!")
             "Whoa, chill out!")))
  (t/testing "Bob responds to shouting with no exclamation mark..."
    (t/is (= (bob/response-for "I HATE THE DMV")
             "Whoa, chill out!"))))

(t/deftest bob-responds-to-statement-containing-question-mark
  (t/testing "Bob responds to statement containing question mark..."
    (t/is (= (bob/response-for "Ending with ? means a question.")
             "Whatever."))))

(t/deftest bob-responds-to-non-letters-with-question
  (t/testing "Bob responds to non-letters with question..."
    (t/is (= (bob/response-for ":) ?")
             "Sure."))))

(t/deftest bob-responds-to-prattling-on
  (t/testing "Bob responds to prattling on..."
    (t/is (= (bob/response-for "Wait! Hang on. Are you going to be OK?")
             "Sure."))))

(t/deftest bob-responds-to-silence
  (t/testing "Bob responds to silence..."
    (t/is (= (bob/response-for "")
             "Fine. Be that way!"))))

(t/deftest bob-responds-to-prolonged-silence
  (t/testing "Bob responds to prolonged silence"
    (t/is (= (bob/response-for "    ")
             "Fine. Be that way!"))))

(t/deftest bob-responds-to-alternate-silence
  (t/testing "Bob responds to alternate silence..."
    (t/is (= (bob/response-for "\t\t\t\t\t\t\t\t\t\t")
             "Fine. Be that way!"))))

(t/deftest bob-responds-to-multiple-line-question
  (t/testing "Bob responds to multiple line question..."
    (t/is (= (bob/response-for "\nDoes this cryogenic chamber make me look fat?\nNo.")
             "Whatever."))))

(t/deftest bob-responds-to-starting-with-whitespace
  (t/testing "Bob responds to starting with whitespace..."
    (t/is (= (bob/response-for "         hmmmmmmm...")
             "Whatever."))))

(t/deftest bob-responds-to-ending-with-whitespace
  (t/testing "Bob responds to ending with whitespace..."
    (t/is (= (bob/response-for "Okay if like my  spacebar  quite a bit?   ")
             "Sure."))))

(t/deftest bob-responds-to-other-whitespace
  (t/testing "Bob responds to other whitespace..."
    (t/is (= (bob/response-for "\n\r \t")
             "Fine. Be that way!"))))

(t/deftest bob-responds-to-non-question-ending-with-whitespace
  (t/testing "Bob responds to non-question-ending with whitespace..."
    (t/is (= (bob/response-for "This is a statement ending with whitespace      ")
             "Whatever."))))
