(ns bob
  (:require [clojure.string]))

(defn- seperate-chat [c r]
  (clojure.string/split c r))

(def ^:private answers
  {:sure-answer "Sure."
   :who-answer "Whoa, chill out!"
   :fine-answer "Fine. Be that way!"
   :whatever-answer "Whatever."})

(defn- get-uppercase-word-count [s]
  (let [w-count (count (re-seq #"\b[A-Z]+\b" s))]
    w-count))

(defn- sure-answer? [s]
  (if (-> s (seperate-chat #"\s")
          last last (= \?))
    :sure-answer))

(defn- whoa-answer? [s]
  (if (or (> (get-uppercase-word-count s) 2) (re-find #"[A-Z]+\!" s))
    :who-answer))

(defn- fine-answer? [s]
  (let [s-count (-> s (clojure.string/replace #"[\s]+" "") count)]
    (if (< s-count 1)
      :fine-answer)))

(defn- whatever-answer? [s]
  (if (nil? s) :whatever-answer s))

(defn- classify-chat [s]
  (let [answer (answers (whatever-answer? (some #{:who-answer :sure-answer :fine-answer} (map #(% s) [whoa-answer? sure-answer? fine-answer?]))))]
    answer))

(defn response-for [c]
  (classify-chat c))
