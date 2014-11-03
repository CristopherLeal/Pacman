:- dynamic pos/2.
:- dynamic pacman/3.
:- dynamic fruit/2.
:- dynamic blinky/2.
:- dynamic clyde/2.
:- dynamic inky/2.
:- dynamic pinky/2.


%%posicoes que podem ser percorridas no labirinto
pos(2,2).
pos(3,2).
pos(4,2).
pos(5,2).
pos(6,2).
pos(7,2).
pos(8,2).
pos(9,2).
pos(10,2).
pos(11,2).
pos(12,2).
pos(13,2).
pos(16,2).
pos(17,2).
pos(18,2).
pos(19,2).
pos(20,2).
pos(21,2).
pos(22,2).
pos(23,2).
pos(24,2).
pos(25,2).
pos(26,2).
pos(27,2).
pos(2,3).
pos(7,3).
pos(13,3).
pos(16,3).
pos(22,3).
pos(27,3).
pos(2,4).
pos(7,4).
pos(13,4).
pos(16,4).
pos(22,4).
pos(27,4).
pos(2,5).
pos(7,5).
pos(13,5).
pos(16,5).
pos(22,5).
pos(27,5).
pos(2,6).
pos(3,6).
pos(4,6).
pos(5,6).
pos(6,6).
pos(7,6).
pos(8,6).
pos(9,6).
pos(10,6).
pos(11,6).
pos(12,6).
pos(13,6).
pos(14,6).
pos(15,6).
pos(16,6).
pos(17,6).
pos(18,6).
pos(19,6).
pos(20,6).
pos(21,6).
pos(22,6).
pos(23,6).
pos(24,6).
pos(25,6).
pos(26,6).
pos(27,6).
pos(2,7).
pos(7,7).
pos(10,7).
pos(19,7).
pos(22,7).
pos(27,7).
pos(2,8).
pos(7,8).
pos(10,8).
pos(19,8).
pos(22,8).
pos(27,8).
pos(2,9).
pos(3,9).
pos(4,9).
pos(5,9).
pos(6,9).
pos(7,9).
pos(10,9).
pos(11,9).
pos(12,9).
pos(13,9).
pos(16,9).
pos(17,9).
pos(18,9).
pos(19,9).
pos(22,9).
pos(23,9).
pos(24,9).
pos(25,9).
pos(26,9).
pos(27,9).
pos(7,10).
pos(13,10).
pos(16,10).
pos(22,10).
pos(7,11).
pos(13,11).
pos(14,11).
pos(15,11).
pos(16,11).
pos(22,11).
pos(7,12).
pos(10,12).
pos(11,12).
pos(12,12).
pos(13,12).
pos(14,12).
pos(15,12).
pos(16,12).
pos(17,12).
pos(18,12).
pos(19,12).
pos(22,12).
pos(7,13).
pos(10,13).
pos(12,13).
pos(19,13).
pos(22,13).
pos(1,14).
pos(2,14).
pos(3,14).
pos(4,14).
pos(5,14).
pos(6,14).
pos(7,14).
pos(8,14).
pos(9,14).
pos(10,14).
pos(12,14).
pos(19,14).
pos(20,14).
pos(21,14).
pos(22,14).
pos(23,14).
pos(24,14).
pos(25,14).
pos(26,14).
pos(27,14).
pos(28,14).
pos(7,15).
pos(10,15).
pos(12,15).
pos(19,15).
pos(22,15).
pos(7,16).
pos(10,16).
pos(11,16).
pos(12,16).
pos(13,16).
pos(14,16).
pos(15,16).
pos(16,16).
pos(17,16).
pos(18,16).
pos(19,16).
pos(22,16).
pos(7,17).
pos(10,17).
pos(19,17).
pos(22,17).
pos(7,18).
pos(10,18).
pos(19,18).
pos(22,18).
pos(2,19).
pos(3,19).
pos(4,19).
pos(5,19).
pos(6,19).
pos(7,19).
pos(8,19).
pos(9,19).
pos(10,19).
pos(11,19).
pos(12,19).
pos(13,19).
pos(16,19).
pos(17,19).
pos(18,19).
pos(19,19).
pos(20,19).
pos(21,19).
pos(22,19).
pos(23,19).
pos(24,19).
pos(25,19).
pos(26,19).
pos(27,19).
pos(2,20).
pos(7,20).
pos(13,20).
pos(16,20).
pos(22,20).
pos(27,20).
pos(2,21).
pos(7,21).
pos(13,21).
pos(16,21).
pos(22,21).
pos(27,21).
pos(2,22).
pos(3,22).
pos(4,22).
pos(7,22).
pos(8,22).
pos(9,22).
pos(10,22).
pos(11,22).
pos(12,22).
pos(13,22).
pos(14,22).
pos(15,22).
pos(16,22).
pos(17,22).
pos(18,22).
pos(19,22).
pos(20,22).
pos(21,22).
pos(22,22).
pos(25,22).
pos(26,22).
pos(27,22).
pos(4,23).
pos(7,23).
pos(10,23).
pos(19,23).
pos(22,23).
pos(25,23).
pos(4,24).
pos(7,24).
pos(10,24).
pos(19,24).
pos(22,24).
pos(25,24).
pos(2,25).
pos(3,25).
pos(4,25).
pos(5,25).
pos(6,25).
pos(7,25).
pos(10,25).
pos(11,25).
pos(12,25).
pos(13,25).
pos(16,25).
pos(17,25).
pos(18,25).
pos(19,25).
pos(22,25).
pos(23,25).
pos(24,25).
pos(25,25).
pos(26,25).
pos(27,25).
pos(2,26).
pos(13,26).
pos(16,26).
pos(27,26).
pos(2,27).
pos(13,27).
pos(16,27).
pos(27,27).
pos(2,28).
pos(3,28).
pos(4,28).
pos(5,28).
pos(6,28).
pos(7,28).
pos(8,28).
pos(9,28).
pos(10,28).
pos(11,28).
pos(12,28).
pos(13,28).
pos(14,28).
pos(15,28).
pos(16,28).
pos(17,28).
pos(18,28).
pos(19,28).
pos(20,28).
pos(21,28).
pos(22,28).
pos(23,28).
pos(24,28).
pos(25,28).
pos(26,28).
pos(27,28).


%%posicao onde existem portais
portal(pos(1,14),pos(28,14),esq).
portal(pos(28,14),pos(1,14),dir).

%%posicoes onde existem frutas
fruit(2,4).
fruit(27,4).
fruit(2,25).
fruit(27,25).

pacman(16,26,'u').


%% retorna os possiveis movimentos
mov(X1,Y1,X2,Y2):-pos(X1,Y1), X2 is X1 , Y2 is Y1+1 ,pos(X2,Y2).
mov(X1,Y1,X2,Y2):-pos(X1,Y1), X2 is X1 , Y2 is Y1-1 ,pos(X2,Y2).
mov(X1,Y1,X2,Y2):-pos(X1,Y1), X2 is X1+1 , Y2 is Y1 , pos(X2,Y2).
mov(X1,Y1,X2,Y2):-pos(X1,Y1), X2 is X1 -1 , Y2 is Y1 , pos(X2,Y2).


%%	executa os movimentos
right:-pacman(X1,Y1,Z1),pos(X1,Y1), X2 is X1+1 , Y2 is Y1 , pos(X2,Y2),retract(pacman(X1,Y1,Z1)),assert(pacman(X2,Y2,'r')).
left:-pacman(X1,Y1,Z1),pos(X1,Y1), X2 is X1-1 , Y2 is Y1 , pos(X2,Y2),retract(pacman(X1,Y1,Z1)),assert(pacman(X2,Y2,'l')).
up:-pacman(X1,Y1,Z1),pos(X1,Y1), X2 is X1 , Y2 is Y1-1 , pos(X2,Y2),retract(pacman(X1,Y1,Z1)),assert(pacman(X2,Y2,'u')).
down:-pacman(X1,Y1,Z1),pos(X1,Y1), X2 is X1 , Y2 is Y1+1 , pos(X2,Y2),retract(pacman(X1,Y1,Z1)),assert(pacman(X2,Y2,'d')).

%%portais
left:- pacman(X1,Y1,Z1),portal(pos(X1,Y1),pos(X2,Y2),esq),retract(pacman(X1,Y1,Z1)),assert(pacman(X2,Y2,'l')).
right:- pacman(X1,Y1,Z1),portal(pos(X1,Y1),pos(X2,Y2),dir),retract(pacman(X1,Y1,Z1)),assert(pacman(X2,Y2,'r')).

comeu:- pacman(X,Y,_),fruit(X,Y),retract(fruit(X,Y)).


%inteligencia do fantasma 1

solvente(X1,Y1,X2,Y2,Solution):- search([],pos(X1,Y1), pos(X2,Y2), Solution).
search(_,pos(X2,Y2),pos(X2,Y2),[pos(X2,Y2)|[]]).
search(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):-Y1<Y2,Y is Y1+1,\+member(pos(X1,Y),Path),mov(X1,Y1,X1,Y),search([pos(X1,Y)|Path],pos(X1,Y),pos(X2,Y2), Sol1).
search(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):-X1<X2,X is X1+1,\+member(pos(X,Y1),Path),mov(X1,Y1,X,Y1),search([pos(X,Y1)|Path],pos(X,Y1),pos(X2,Y2), Sol1).
search(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):-Y1>Y2,Y is Y1-1,\+member(pos(X1,Y),Path),mov(X1,Y1,X1,Y),search([pos(X1,Y)|Path],pos(X1,Y),pos(X2,Y2), Sol1).
search(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):-X1>X2,X is X1-1,\+member(pos(X,Y1),Path),mov(X1,Y1,X,Y1),search([pos(X,Y1)|Path],pos(X,Y1),pos(X2,Y2), Sol1).
search(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):-Y is Y1+1,\+member(pos(X1,Y),Path),mov(X1,Y1,X1,Y),search([pos(X1,Y)|Path],pos(X1,Y),pos(X2,Y2), Sol1).
search(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):-X is X1+1,\+member(pos(X,Y1),Path),mov(X1,Y1,X,Y1),search([pos(X,Y1)|Path],pos(X,Y1),pos(X2,Y2), Sol1).
search(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):-Y is Y1-1,\+member(pos(X1,Y),Path),mov(X1,Y1,X1,Y),search([pos(X1,Y)|Path],pos(X1,Y),pos(X2,Y2), Sol1).
search(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):-X is X1-1,\+member(pos(X,Y1),Path),mov(X1,Y1,X,Y1),search([pos(X,Y1)|Path],pos(X,Y1),pos(X2,Y2), Sol1).


solve2(X1,Y1,X2,Y2,Solution):- search2([],pos(X1,Y1), pos(X2,Y2), Solution).
search2(_,pos(X2,Y2),pos(X2,Y2),[pos(X2,Y2)|[]]).
search2(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):- \+(X1==X2),X is X1+1,\+(member(pos(X,Y1),Path)),mov(X1,Y1,X,Y1),search2([pos(X,Y1)|Path],pos(X,Y1),pos(X2,Y2), Sol1).
search2(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):- \+(X1==X2),X is X1-1,\+(member(pos(X,Y1),Path)),mov(X1,Y1,X,Y1),search2([pos(X,Y1)|Path],pos(X,Y1),pos(X2,Y2), Sol1).
search2(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):- \+(Y1==Y2),Y is Y1+1,\+(member(pos(X1,Y),Path)),mov(X1,Y1,X1,Y),search2([pos(X1,Y)|Path],pos(X1,Y),pos(X2,Y2), Sol1).
search2(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):- \+(Y1==Y2),Y is Y1-1,\+(member(pos(X1,Y),Path)),mov(X1,Y1,X1,Y),search2([pos(X1,Y)|Path],pos(X1,Y),pos(X2,Y2), Sol1).
search2(Path,pos(X1,Y1),pos(X1,Y2),[pos(X1,Y1)|Sol1]):-X is X1+1,\+member(pos(X,Y1),Path),mov(X1,Y1,X,Y1),search2([pos(X,Y1)|Path],pos(X,Y1),pos(X1,Y2), Sol1).
search2(Path,pos(X1,Y1),pos(X1,Y2),[pos(X1,Y1)|Sol1]):-X is X1-1,\+member(pos(X,Y1),Path),mov(X1,Y1,X,Y1),search2([pos(X,Y1)|Path],pos(X,Y1),pos(X1,Y2), Sol1).
search2(Path,pos(X1,Y1),pos(X2,Y1),[pos(X1,Y1)|Sol1]):-Y is Y1+1,\+member(pos(X1,Y),Path),mov(X1,Y1,X1,Y),search2([pos(X1,Y)|Path],pos(X1,Y),pos(X2,Y1), Sol1).
search2(Path,pos(X1,Y1),pos(X2,Y1),[pos(X1,Y1)|Sol1]):-Y is Y1-1,\+member(pos(X1,Y),Path),mov(X1,Y1,X1,Y),search2([pos(X1,Y)|Path],pos(X1,Y),pos(X2,Y1), Sol1).


path(X1,Y1,X2,Y2,Path) :-travel(pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)],Q),reverse(Q,Path).

travel(pos(X1,Y1),pos(X2,Y2),P,[pos(X2,Y2)|P]) :-mov(X1,Y1,X2,Y2).
travel(pos(X1,Y1),pos(X2,Y2),Visited,Path) :- mov(X1,Y1,X,Y), pos(X,Y) \== pos(X2,Y2), 
\+member(pos(X,Y),Visited), travel(pos(X,Y),pos(X2,Y2),[pos(X,Y)|Visited],Path).

%% movimento dos fantasmas

% quando o jogo comeca ou fantasma morre
blinky(19,16).
clyde(19,19).
inky(16,16).
pinky(16,19).

% executa os movimentos de cada fantasma

rightBlinky:-blinky(X1,Y1),pos(X1,Y1), X2 is X1+1 , Y2 is Y1 , pos(X2,Y2),retract(blinky(X1,Y1)),assert(blinky(X2,Y2)).
leftBlinky:-blinky(X1,Y1),pos(X1,Y1), X2 is X1-1 , Y2 is Y1 , pos(X2,Y2),retract(blinky(X1,Y1)),assert(blinky(X2,Y2)).
upBlinky:-blinky(X1,Y1),pos(X1,Y1), X2 is X1 , Y2 is Y1-1 , pos(X2,Y2),retract(blinky(X1,Y1)),assert(blinky(X2,Y2)).
downBlinky:-blinky(X1,Y1),pos(X1,Y1), X2 is X1 , Y2 is Y1+1 , pos(X2,Y2),retract(blinky(X1,Y1)),assert(blinky(X2,Y2)).

rightClyde:-clyde(X1,Y1),pos(X1,Y1), X2 is X1+1 , Y2 is Y1 , pos(X2,Y2),retract(clyde(X1,Y1)),assert(clyde(X2,Y2)).
leftClyde:-clyde(X1,Y1),pos(X1,Y1), X2 is X1-1 , Y2 is Y1 , pos(X2,Y2),retract(clyde(X1,Y1)),assert(clyde(X2,Y2)).
upClyde:-clyde(X1,Y1),pos(X1,Y1), X2 is X1 , Y2 is Y1-1 , pos(X2,Y2),retract(clyde(X1,Y1)),assert(clyde(X2,Y2)).
downClyde:-clyde(X1,Y1),pos(X1,Y1), X2 is X1 , Y2 is Y1+1 , pos(X2,Y2),retract(clyde(X1,Y1)),assert(clyde(X2,Y2)).

rightInky:-inky(X1,Y1),pos(X1,Y1), X2 is X1+1 , Y2 is Y1 , pos(X2,Y2),retract(inky(X1,Y1)),assert(inky(X2,Y2)).
leftInky:-inky(X1,Y1),pos(X1,Y1), X2 is X1-1 , Y2 is Y1 , pos(X2,Y2),retract(inky(X1,Y1)),assert(inky(X2,Y2)).
upInky:-inky(X1,Y1),pos(X1,Y1), X2 is X1 , Y2 is Y1-1 , pos(X2,Y2),retract(inky(X1,Y1)),assert(inky(X2,Y2)).
downInky:-inky(X1,Y1),pos(X1,Y1), X2 is X1 , Y2 is Y1+1 , pos(X2,Y2),retract(inky(X1,Y1)),assert(inky(X2,Y2)).

rightPinky:-pinky(X1,Y1),pos(X1,Y1), X2 is X1+1 , Y2 is Y1 , pos(X2,Y2),retract(pinky(X1,Y1)),assert(pinky(X2,Y2)).
leftPinky:-pinky(X1,Y1),pos(X1,Y1), X2 is X1-1 , Y2 is Y1 , pos(X2,Y2),retract(pinky(X1,Y1)),assert(pinky(X2,Y2)).
upPinky:-pinky(X1,Y1),pos(X1,Y1), X2 is X1 , Y2 is Y1-1 , pos(X2,Y2),retract(pinky(X1,Y1)),assert(pinky(X2,Y2)).
downPinky:-pinky(X1,Y1),pos(X1,Y1), X2 is X1 , Y2 is Y1+1 , pos(X2,Y2),retract(pinky(X1,Y1)),assert(pinky(X2,Y2)).


% quando o pacman come o fantasma
comerBlinky :- pacman(X,Y,_),blinky(X,Y),retract(blinky(X,Y)),assert(blinky(19,16)),retract(podeComerBlinky).
comerClyde :- pacman(X,Y,_),clyde(X,Y),retract(clyde(X,Y)),assert(clyde(19,19)),retract(podeComerClyde).
comerInky :- pacman(X,Y,_),inky(X,Y),retract(inky(X,Y)),assert(inky(16,16)),retract(podeComerInky).
comerPink :- pacman(X,Y,_),pink(X,Y),retract(pink(X,Y)),assert(pink(16,19)),retract(podeComerPinky).


colisao:-pacman(X,Y,_),blinky(X,Y).
colisao:-pacman(X,Y,_),inky(X,Y).
colisao:-pacman(X,Y,_),clyde(X,Y).
colisao:-pacman(X,Y,_),pinky(X,Y).



