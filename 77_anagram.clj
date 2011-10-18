; Anagram Finder, 4Clojure problem #77

; Observation: two words are anagrams if their sorted characters are equal.

(defn anagram? [s t] (= (sort s) (sort t)))

(fn [s t] (= (sort s) (sort t)))

; We can do a set difference with 

(defn eq-ana [words]
	(loop [s words r #{}]
	   (if (empty? s) r
         (let [n (set (filter #(anagram? % (first s)) s))]
           (recur (remove n s)
                  (if (> (count n) 1)
                        (conj r n)
                        r))))))

(fn [w]
	(loop [s w r #{}]
	   (if (empty? s) r
         (let [n (set (filter #((fn [s t] (= (sort s) (sort t))) % (first s)) 
                              s))]
           (recur (remove n s)
                  (if (> (count n) 1)
                        (conj r n)
                        r))))))