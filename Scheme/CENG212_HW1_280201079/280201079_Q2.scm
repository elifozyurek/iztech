#lang scheme
;question 2
(define list_sum
  (lambda (x_list)
    (if (= (length x_list) 1) (car x_list)  ;if length of list is 1, returns the first element of the list (base case)
    (+ (list_sum (cdr x_list)) (car x_list))   ;procedure calls itself with the rest of the list
    )
  ) 
)

;prodecure calls for arbitrary lists
(list_sum (list 2 5 7))
(list_sum (list 4 15 21 96))
