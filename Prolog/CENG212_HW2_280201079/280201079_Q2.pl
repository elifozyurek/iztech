?- is_faculty_member('Damla Oguz').
% true.
?- is_faculty_member('Elif Ozyurek').
% false.

?- is_assistant_of('Huseyin Unlu', ceng212).
% true.
?- is_assistant_of('Emre Dincer', ceng216).
% false.

?- assist_same_course('Adil Coban', 'Emre Dincer').
% true.
?- assist_same_course('Burak Topcu', 'Ersin Cine').
% false.

?- courses_given_by_same_prof(ceng216, ceng218).
% true.
?- courses_given_by_same_prof(ceng222, ceng212).
% false.

?- does_not_teach_year2_courses('Cuneyt Fehmi Bazlamacci').
% true.
?- does_not_teach_year2_courses('Nesli Erdogmus').
% false.

?- is_year2_course(ceng214).
% true.
?- is_year2_course(ceng115).
% false.
