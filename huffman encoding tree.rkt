#lang sicp
(define (make-leaf symbol weight)
    (list 'leaf symbol weight))

(define (leaf? object)
    (eq? (car object) 'leaf))

(define symbol-leaf cadr)

(define weight-leaf caddr)

(define (make-code-tree left right)
    (list left
          right
          (append (symbols left) (symbols right))
          (+ (weight left) (weight right))))

(define left-branch car)

(define right-branch cadr)

(define (symbols tree)
    (if (leaf? tree)
        (list (symbol-leaf tree))
        (caddr tree)))

(define (weight tree)
    (if (leaf? tree)
        (weight-leaf tree)
        (cadddr tree)
    )
)

(define (element? x set) 
   (cond ((null? set) false) 
         ((equal? x (car set)) true) 
         (else (element? x (cdr set)))
    )
)

(define (decode bits tree)
    (define (decode-1 bits current-branch)
        (if (null? bits)
            '()
            (let ((next-branch
                    (choose-branch (car bits) current-branch)))
                (if (leaf? next-branch)
                    (cons (symbol-leaf next-branch)
                          (decode-1 (cdr bits) tree))
                    (decode-1 (cdr bits) next-branch)))))
    (decode-1 bits tree))

(define (choose-branch bit branch)
    (cond ((= bit 0)
            (left-branch branch))
          ((= bit 1)
            (right-branch branch))
          (else
            (error "bad bit -- CHOOSE-BRANCH" bit))))

(define (encode message tree) 
   (if (null? message) 
        nil
       (append (encode-symbol (car message) tree) (encode (cdr message) tree))
   )
) 

(define (encode-symbol symbol tree)
  (define(iter symbol tree result)
    (let ((lb (left-branch tree)) 
          (rb (right-branch tree))
          )
     (cond((leaf? tree)                       result)
          ((element? symbol (symbols lb))     (iter symbol lb (append result '(0))))
          ((element? symbol (symbols rb))     (iter symbol rb (append result '(1))))
          (else                               (error "symbol not in tree"))
     )
    )
  )
  (iter symbol tree nil)
)  
       
(define (adjoin x set)
  (cond((null? set) (list x))
       ((< (weight x) (weight(car set))) (cons x set))
       (else (cons (car set) (adjoin x (cdr set))))
  )
)

(define (make-set pairs)
  (if (null? pairs)
      nil
      (adjoin (make-leaf (caar pairs) (cadar pairs))               ;symbol and frequency
              (make-set (cdr pairs))
      )
  )
)  

(define (merge set-of-pairs)
  (cond((= (length set-of-pairs) 0)  nil)
       ((= (length set-of-pairs) 1) (car set-of-pairs))
       (else (merge(adjoin (make-code-tree (car set-of-pairs) (cadr set-of-pairs)) (cddr set-of-pairs))))
  )
)  
               