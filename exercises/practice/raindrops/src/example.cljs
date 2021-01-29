(ns raindrops)

(def ^:private n->P
  {3 "Pling"
   5 "Plang"
   7 "Plong"})

(defn- factors-of [n]
  (filter integer? (map (partial / n) (range 1 (inc (/ n 2))))))

(defn- one-of-them [nsq them]
  (filter them nsq))

(defn- P-of-nsq [nsq]
  (apply str (map n->P (reverse nsq))))

(defn- if-there-is-no-P [r n]
  (if (empty? r) (str n) r))

(defn convert
  [n]
  (-> n factors-of (one-of-them (apply hash-set (keys n->P))) P-of-nsq (if-there-is-no-P n)))
