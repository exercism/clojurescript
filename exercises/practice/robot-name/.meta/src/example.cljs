(ns robot-name)

(def ^:private letters (map char (range 65 91)))
(defn- generate-name []
  (apply str 
    (concat (repeatedly 2 #(rand-nth letters))
            (repeatedly 3 #(rand-int 10)))))

(defn robot []
  (atom {:name (generate-name)}))

(defn robot-name [robot]
  (:name @robot))

(defn reset-name [robot]
  (swap! robot assoc :name (generate-name)))
