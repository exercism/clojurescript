(ns allergies)

(def ^:private allergy-number
  {:eggs 1
   :peanuts 2
   :shellfish 4
   :strawberries 8
   :tomatoes 16
   :chocolate 32
   :pollen 64
   :cats 128})

(defn- total-allergic-points [allergy-number]
  (apply + (map second allergy-number)))

(defn- allergic->name [ans]
  (map first ans))

(defn- check-allergy [x y]
  (> (bit-and x y)
     0))

(defn- allergic? [an allergy-number]
  (filter #(check-allergy an (second %))
          allergy-number))

(defn- validate-allergy-number [an tan]
  (if (> an tan)
    (bit-and an tan)
    an))

(defn allergies [an]
  (-> an
      (validate-allergy-number (total-allergic-points allergy-number))
      (allergic? allergy-number)
      allergic->name
      vec))

(defn allergic-to? [an at]
  (-> (partial = at)
      (filter
       (allergies an))
      vec
      count
      zero?
      not))
