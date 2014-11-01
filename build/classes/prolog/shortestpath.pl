

edge(pos(X,Y1),pos(X,Y2)):-Y1 is Y2-1.
edge(pos(X1,Y),pos(X2,Y)):-X1 is X2-1.
edge(pos(X,Y1),pos(X,Y2)):-Y1 is Y2+1.
edge(pos(X1,Y),pos(X2,Y)):-X1 is X2+1.

solve(pos(X1,Y1), pos(X2,Y2), Solution):- search([],pos(X1,Y1), pos(X2,Y2), Solution).
search(_,pos(X2,Y2),pos(X2,Y2),[pos(X2,Y2)|[]]).
search(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):-X is X1+1,X=<X2, edge(pos(X1,Y1),pos(X,Y1)),search([pos(X,Y1)|Path],pos(X,Y1),pos(X2,Y2), Sol1),!.
search(Path,pos(X1,Y1),pos(X2,Y2),[pos(X1,Y1)|Sol1]):-Y is Y1+1,Y=<Y2, edge(pos(X1,Y1),pos(X1,Y)),search([pos(X1,Y)|Path],pos(X1,Y),pos(X2,Y2), Sol1),!.



