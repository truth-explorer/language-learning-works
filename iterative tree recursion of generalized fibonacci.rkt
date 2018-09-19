;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname |iterative tree recursion of generalized fibonacci|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define (f n)
  (if (< n 3)
      n
      (iter 0 1 2 n)))
(define (iter a b c count)
  (if (< count 3)
      c
      (iter b c (+ (* 3 a) (* 2 b) c) (- count 1))))
       