; For the 4Clojure Levenshtein distance problem.
; http://en.wikipedia.org/wiki/Levenshtein_distance

(ns four-clojure
  (:require clojure.test))

  (clojure.test/with-test
    (defn lev-dist
        "Computes the Levenshtein distance between two seqs."
        [seq1 seq2]
        (if (not (and (seq? seq1) (seq? seq2)))
          (throw (IllegalArgumentException. "lev-dist failed: Both arguments must be seqs.")))
        5)
    
    (is (= (lev-dist "kitten" "sitting") 3))
    (is (= (lev-dist "closure" "clojure") (lev-dist "clojure" "closure") 1))
    (is (= (lev-dist "xyx" "xyyyx") 2))
    (is (= (lev-dist "" "123456") 6))
    (is (= (lev-dist "Clojure" "Clojure") (lev-dist "" "") (lev-dist [] []) 0))
    (is (= (lev-dist [1 2 3 4] [0 2 3 4 5]) 2))
    (is (= (lev-dist '(:a :b :c :d) '(:a :d)) 2))
    (is (= (lev-dist "ttttattttctg" "tcaaccctaccat") 10))
    (is (= (lev-dist "gaattctaatctc" "caaacaaaaaattt") 9)))