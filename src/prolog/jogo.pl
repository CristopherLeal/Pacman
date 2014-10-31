
start:- consult('level1.pl').

%% retorna os possiveis movimentos
mov(X1,Y1,X2,Y2):-pos(X1,Y1), X2 is X1 , Y2 is Y1+1 ,pos(X2,Y2).
mov(X1,Y1,X2,Y2):-pos(X1,Y1), X2 is X1 , Y2 is Y1-1 ,pos(X2,Y2).
mov(X1,Y1,X2,Y2):-pos(X1,Y1), X2 is X1+1 , Y2 is Y1 , pos(X2,Y2).
mov(X1,Y1,X2,Y2):-pos(X1,Y1), X2 is X1 -1 , Y2 is Y1 , pos(X2,Y2).


%%	executa os movimentos
right:-pacman(X1,Y1),pos(X1,Y1), X2 is X1+1 , Y2 is Y1 , pos(X2,Y2),retract(pacman(X1,Y1)),assert(pacman(X2,Y2)).
left:-pacman(X1,Y1),pos(X1,Y1), X2 is X1-1 , Y2 is Y1 , pos(X2,Y2),retract(pacman(X1,Y1)),assert(pacman(X2,Y2)).
up:-pacman(X1,Y1),pos(X1,Y1), X2 is X1 , Y2 is Y1-1 , pos(X2,Y2),retract(pacman(X1,Y1)),assert(pacman(X2,Y2)).
down:-pacman(X1,Y1),pos(X1,Y1), X2 is X1 , Y2 is Y1+1 , pos(X2,Y2),retract(pacman(X1,Y1)),assert(pacman(X2,Y2)).

%%portais
left:- pacman(X1,Y1),portal(pos(X1,Y1),pos(X2,Y2),esq),retract(pacman(X1,Y1)),assert(pacman(X2,Y2)).
right:- pacman(X1,Y1),portal(pos(X1,Y1),pos(X2,Y2),dir),retract(pacman(X1,Y1)),assert(pacman(X2,Y2)).

comeu:- pacman(X,Y),fruit(X,Y),retract(fruit(X,Y)).
