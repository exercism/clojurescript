(ns pascals-triangle
  "Calculates the `Pascal Triangle` in lazy way."
  {:author [:LeaveNhA "Seçkin KÜKRER"]
   :last-update-date "24-09-2019"})

(defn row [r]
  (if (vector? r)
    (lazy-seq (cons r
                    (row (vec (concat [1N] (map (partial apply +) (partition 2N 1N r)) [1N])))))
    (last (take r (row [1])))))

(def triangle
  (row [1]))