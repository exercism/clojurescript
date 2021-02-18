(ns run-length-encoding
  (:require [clojure.set]))

(defn- map-flip-vector
  "Takes seq and flip it's k-v pair as v-k."
  [m]
  (map #(vector (second %) (first %)) m))

(defn- map->string
  "Takes seq and reduce to it single string value."
  [m]
  (reduce #(str % (str (if (= 1 (first %2)) "" (first %2))
                             (second %2))) "" m))

(defn- replace-space-s
  "Space replacement."
  [m]
  (apply str (map (fn [v] (if (= \space v) \space v)) m)))

(defn- rl-part->structure
  "rl-part is a part of the abstraction.
   Takes non-structured --yet-- data and turn it to structured for processing."
  [rl]
  (->> rl (map #(re-seq #"([0-9]*)([A-Za-z\s])" %)) (map (comp rest flatten))))

(defn- structure->string
  "Structured value to String.
   [number l] --l is character--"
  [[n l]]
  (map (fn [_] (identity l)) (range (int (if (empty? n) 1 n)))))

(defn- over-structure
  "Apply structure to string function to parted-structured-data."
  [v]
  (map structure->string v))

(defn- count-rls!
  "Count the partitioned data."
  [rls]
  (map (fn [v] (vector (first v) (count v))) rls))

(defn- string->rl-part
  "First part of the abstraction.
   Implement the number-character seperation before the processing function."
  [s]
  (re-seq #"[0-9]*[A-Za-z\s]" s))

(defn run-length-encode
  "encodes a string with run-length-encoding."
  [s]
  (->> s (partition-by identity) count-rls! map-flip-vector map->string))

(defn run-length-decode
  "Decodes a run-length-encoded string."
  [s]
  (apply str (->> s replace-space-s string->rl-part rl-part->structure over-structure flatten)))
