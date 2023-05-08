; From https://exercism.org/tracks/clojure/exercises/rotational-cipher/solutions/acamargo

(ns rotational-cipher
  (:require [clojure.string :as s]))

(def ^:const alphabet "abcdefghijklmnopqrstuvwxyz")

(defn rotate [text key]
  (let [shifted (take 26 (drop (mod key 26) (cycle alphabet)))
        cipher (zipmap (str alphabet (s/upper-case alphabet))
                       (concat shifted (map s/upper-case shifted)))]
    (s/join (map #(cipher %1 %1) text))))
