select id, username, password pwd, mobile_no, age from /*<<wrap*/user
where 
/*<if test=name?? && name == 'yi'*/ name = yi
/*<elseif test=name??*/ name = :name
/*<else*/ name is null
/*>if*/