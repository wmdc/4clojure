; Tree symmetry, 4Clojure problem #96

; We can have left-handed or right-handed walks:

(defn lhw [n]
	(if (nil? n) nil
	    (concat (lhw (fnext n))
		    [(first n)]
		    (lhw (last n)))))
        
(defn rhw [n]
	(if (nil? n) nil
	    (concat (rhw (last n))
		    [(first n)]
		    (rhw (fnext n)))))
        
; Symmetry by problem definition when the two walks are equal:

(defn symm? [t]
  (= (rhw t) (lhw t)))
  
; One-liners and anonymous fn

(defn l [n] (if (nil? n) nil (concat (l (fnext n)) [(first n)] (l (last n)))))
(defn r [n] (if (nil? n) nil (concat (r (last n)) [(first n)] (r (fnext n)))))

(defn symm? [t]
  (= ((fn l [n] (if (nil? n) nil (concat (l (fnext n)) [(first n)] (l (last n))))) t)
     ((fn r [n] (if (nil? n) nil (concat (r (last n)) [(first n)] (r (fnext n))))) t)))

; There's a ton of redundant code here obviously! A candidate for code golf.
     
(fn [t]
  (= ((fn l [n] (if (nil? n) nil (concat (l (fnext n)) [(first n)] (l (last n))))) t)
     ((fn r [n] (if (nil? n) nil (concat (r (last n)) [(first n)] (r (fnext n))))) t)))