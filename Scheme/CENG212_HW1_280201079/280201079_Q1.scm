#lang scheme
;question 1
(define sum_of_evens
  (lambda (n)
    (cond
        ((or (= n 1) (= n 0)) 0)    ;if n is 0 or 1, sum will be 0 (base case)
        ((and (even? n) (not (= n 2))) (+ (sum_of_evens (- n 2)) n))    ;if n is even and not 2, procedure will call itself
        ((and (odd? n) (not (= n 2))) (+ (sum_of_evens (- n 3)) (- n 1)))   ;if n is odd and 2, procedure will call itself
        (else 2)   ;if n is 2, sum will be 2 (base case)
     )
   )
)

;procedure calls for some n values
(sum_of_evens 0)
(sum_of_evens 1)
(sum_of_evens 2)
(sum_of_evens 10)
(sum_of_evens 11)
