pos(1,1).
pos(1,2).
pos(1,3).
pos(1,4).
pos(2,1).
pos(3,1).
pos(4,1).
pos(5,1).
pos(4,2).
pos(4,3).
pos(6,1).
pos(7,1).
pos(7,2).
pos(7,3).
pos(7,4).
pos(8,4).
pos(8,1).
pos(9,1).
pos(10,1).
pos(11,1).
pos(11,2).
pos(12,2).
pos(12,3).
pos(12,4).
pos(12,5).
pos(12,6).
pos(11,6).
pos(10,6).
pos(10,7).
pos(10,8).
pos(10,9).
pos(11,9).


edge(pos(X,Y1),pos(X,Y2)):-Y1 is Y2-1.
edge(pos(X1,Y),pos(X2,Y)):-X1 is X2-1.
edge(pos(X,Y1),pos(X,Y2)):-Y1 is Y2+1.
edge(pos(X1,Y),pos(X2,Y)):-X1 is X2+1.

solve(pos(X1,Y1), pos(X2,Y2), Solution):- search([],pos(X1,Y1), pos(X2,Y2), Solution).
search(_,pos(X2,Y2),pos(X2,Y2),[pos(X2,Y2)|[]]).
search(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):-X is X1+1,X=<X2, edge(pos(X1,Y1),pos(X,Y1)),search([pos(X,Y1)|Path],pos(X,Y1),pos(X2,Y2), Sol1),!.
search(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):-Y is Y1+1,Y=<Y2, edge(pos(X1,Y1),pos(X1,Y)),search([pos(X1,Y)|Path],pos(X1,Y),pos(X2,Y2), Sol1),!.



