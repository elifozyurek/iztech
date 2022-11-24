course(ceng212).
course(ceng214).
course(ceng216).
course(ceng218).
course(ceng222).
course(ceng115).
course(ceng112).

assistant_prof('Damla Oguz').
assistant_prof('Burak Galip Aslan').
assistant_prof('Mustafa Ozuysal').
assistant_prof('Nesli Erdogmus').

research_assist('Huseyin Unlu').
research_assist('Ersin Cine').
research_assist('Adil Coban').
research_assist('Emre Dincer').
research_assist('Burak Topcu').
research_assist('Ersin Cine').

head_of_department('Cuneyt Fehmi Bazlamacci').

teach('Damla Oguz', ceng212).
teach('Burak Galip Aslan', ceng214).
teach('Mustafa Ozuysal', ceng216).
teach('Mustafa Ozuysal', ceng218).
teach('Nesli Erdogmus', ceng222).

assist('Serhat Caner', ceng212).
assist('Huseyin Unlu', ceng212).
assist('Emre Dincer', ceng214).
assist('Adil Coban', ceng214).
assist('Ersin Cine', ceng216).
assist('Adil Coban', ceng222).
assist('Burak Topcu', ceng222).

is_faculty_member(X) :-
    assistant_prof(X);
    research_assist(X).
is_assistant_of(Member, Class) :-
    research_assist(Member),
    assist(Member, Class).
assist_same_course(Assistant1, Assistant2) :-
    assist(Assistant1, Course),
    assist(Assistant2, Course).
courses_given_by_same_prof(Course1, Course2) :-
    teach(X, Course1),
    teach(X, Course2).
does_not_teach_year2_courses(Person) :-
    head_of_department(Person).
is_year2_course(Y) :-
    Y = ceng212;
    Y = ceng214;
    Y = ceng216;
    Y = ceng218;
    Y = ceng222.
