; Game of Life, 4Clojure problem #94

(defn read-life [c]
  {:width (count c),
   :data (apply concat c)})
   
(defn cell-val [cell neighbours]
   (let [t (reduce #(if (= \# %2) (inc %1) %1) 0 neighbours)]
     (cond (and (= cell \s 