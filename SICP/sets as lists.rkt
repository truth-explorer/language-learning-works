#lang sicp
(define (equal? x y)
    (cond ((and (symbol? x) (symbol? y))
            (eq? x y))
          ((and (list? x) (list? y))
            (list-equal? x y))
          (else
            (error "Wrong type input x and y -- EQUAL?" x y))))
(define (list-equal? x y)
  (cond ((and (null? x) (null? y))  #t)                             ; 空表
        ((or (null? x) (null? y))   #f)                              ; 长度不同的表
        ((equal? (car x) (car y)) (equal? (cdr x) (cdr y)))
        (else #f)
   )
)
(define (element? x set)
  (cond ( (null? set) false)
        ( (equal? x (car set)) true)
        ( else (element? x (cdr set)))
  )
)
(define (adjoin x set)
  (if (element? x set)
      set
      (cons set x)
  )
)  
(define (intersection s1 s2)
  (cond ((or (null? s1) (null? s2)) nil)
        ((element? (car s1) s2)
            (cons (car s1) (intersection (cdr s1) s2))
        )
        (else (intersection (cdr s1) s2))
  )
)
(define (union s1 s2)
  (if (null? s2)
      s1
      (union (adjoin (car s2) s1) (cdr s2))
  )
)  
        
         
           

