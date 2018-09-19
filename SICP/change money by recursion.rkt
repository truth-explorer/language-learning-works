;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname |change money by recursion|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define (cc amount coin-values)
    (cond ((= amount 0) 1)
          ((or (< amount 0) (no-more? coin-values)) 0)
          (else
            (+ (cc amount (except-first-denomination coin-values))
               (cc (- amount (first-denomination coin-values))  coin-values))
           )
     )
)

(define (first-denomination coin-values)
    (car coin-values))

(define (except-first-denomination coin-values)
    (cdr coin-values))

(define (no-more? coin-values)
    (null? coin-values))
(define us-coins (list 50 25 10 5 1))
(define uk-coins (list 100 50 20 10 5 2 1 0.5))
