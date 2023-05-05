(ns matching-brackets)

(def ^:private convert
  {\{ \}
   \} \{
   \[ \]
   \] \[
   \( \)
   \) \(})

(defn- check-pair [acc p]
  (if (= (peek acc)
         (convert p))
    (pop acc)
    nil))

(defn valid? [bracket-string]
  (every? true? ((juxt empty? (comp not nil?))
                 (reduce (fn [acc p]
                           (if (nil? acc)
                             nil
                             (case p
                               \{ (conj acc p)
                               \} (check-pair acc p)
                               \[ (conj acc p)
                               \] (check-pair acc p)
                               \( (conj acc p)
                               \) (check-pair acc p)
                               acc)))
                         []
                         bracket-string))))
