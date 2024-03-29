(ns bob
  (:require [clojure.string :as str]))

(defn- silence?    [msg] (str/blank? msg))

(defn- question?   [msg] (= \? (last msg)))

(defn- shouting?   [msg] (and (= msg (str/upper-case msg))
                              (not= msg (str/lower-case msg))))

(defn- forceful-question? [msg]
  (and (shouting? msg) (question? msg)))

(defn response-for [input]
  (let [clean (str/trim input)]
    (cond
      (forceful-question? clean) "Calm down, I know what I'm doing!"
      (silence?  clean) "Fine. Be that way!"
      (shouting? clean) "Whoa, chill out!"
      (question? clean) "Sure."
      :else             "Whatever.")))
