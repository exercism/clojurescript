(ns two-fer-test
  (:require [two-fer]
            [cljs.test :as t :include-macros true]))

(t/deftest two-fer-no-args-test
  (t/testing "Two-Fer implementation testing."
    (let [no-args-result "One for you, one for me."
          sarah-result "One for Sarah, one for me."]
      (t/is (= (two-fer/two-fer "Sarah")
               sarah-result))
      (t/is (= (two-fer/two-fer)
               no-args-result)))))
