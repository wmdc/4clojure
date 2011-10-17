;Solution for finding anagrams, built for 4Clojure.org problem #77

(defn extract 
  "If item is in coll, returns coll with one occurrence of item removed. Otherwise returns nil."
  [item coll]
	    (loop [n (dec (count coll))]
	       (cond (= item (nth coll n))
		       (let [s (split-at n coll)]
			    (into (first s) (rest (last s))))
		     (> n 0)
		       (recur (dec n)))))
           
(defn anagram?
  "Returns true if s and t are anagrams of each other and false otherwise."
  [s t]
	    (if (= (count s) (count t))
		(= (count s) (reduce + (map #(if (= nil (extract % t)) 0 1) s)))
		false))
    
(defn anagram-sets
	  "Returns sets where all members are anagrams of every other member."
	  [coll]
	  (loop [c (set coll) r #{}]
	     (if (empty? c) 
		 r
		 (let [s (reduce #(if (anagram? (first %1) %2) (conj %1 %2) %1) #{(first c)} c)]
		     (recur (clojure.set/difference c s) 
                (if (> (count s) 2)
                    (conj r s)
                    r))))))
                    
                    
; Anonymous fn for 4Clojure