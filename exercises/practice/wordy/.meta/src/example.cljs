(ns wordy
  (:require [clojure.string :refer [join]]))

(def ^:private ops {"plus" +
                    "minus" -
                    "multiplied by" *
                    "divided by" /})

(def ^:private tokens-pattern (re-pattern
                               (str (join "|" (keys ops)) "|-?\\d+|\\S+")))

(defn- parse-op [op-str]
  (or (ops op-str)
      (throw (js/Error. (str "unknown operator " op-str)))))

(defn evaluate [expr]
  (if-let [[_ exprs] (re-matches #"What is (.+)\?" expr)]
    (if-let [[token & tokens] (re-seq tokens-pattern exprs)]
      (reduce (fn [acc [op x]]
                ((parse-op op) acc (js/parseInt x)))
              (js/parseInt token) (partition-all 2 tokens))
      (throw (js/Error. "no arithmetic expression found")))
    (throw (js/Error. "cannot recognize question"))))
