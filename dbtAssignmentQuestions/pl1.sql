/*drop procedure if exists pro1;
delimiter $
create procedure pro1()
begin 
	select 'Hello World' R1;
end $

delimiter ;



drop procedure if exists pro1;
delimiter $
create procedure pro1()
begin 
	declare x int default 100;
	set @z := now();
	select x, @a;
end $

delimiter ;



drop procedure if exists pro1;
delimiter $
create procedure pro1(x int, in y int)
begin 
	select x+y;
end $

delimiter ;


drop procedure if exists pro1;
delimiter $
create procedure pro1(in x int, in y int, out z int)
begin 
	set z := x + y;
end $
delimiter ;


drop procedure if exists pro1;
delimiter $
create procedure pro1(in x int, in y int, out z int, out z1 int)
begin 
	set z := x+y;
	set z1 := x*y;
end $
delimiter ;


drop procedure if exists pro1;
delimiter $
create procedure pro1(in x int)
begin 
	if x = 100 THEN
		select  'Good';
	ELSE
		select 'Not Good';
	end  if;
end $
delimiter ;



drop procedure if exists pro1;
delimiter $
create procedure pro1()
begin 
	declare x int default 1;
		l:LOOP
			select x;
			set x:= x+1;
			
			if x=11 THEN
				leave l;
			end if;
		end loop l;
end $
delimiter ;



drop procedure if exists pro1;
delimiter $
create procedure pro1(in a int)
begin 
	declare x int default 1;
		l:LOOP
			select x;
			set x:= x+1;
			
			if x>a THEN
				leave l;
			end if;
		end loop l;
end $
delimiter ;


drop procedure if exists pro1;
delimiter $
create procedure pro1(in x int)
begin 
	declare flag bool default false;
	select distinct true into flag from emp where deptno = x;
	
	
	if flag = true THEN
		select ename, job, deptno from emp where deptno=x;
	ELSE
		select 'Not found';
	end if;
end $
delimiter ;





drop procedure if exists pro1;
delimiter $
create procedure pro1()
begin 
	declare z int default 0;
	
	select count(*)- 5 into z from emp;
	
	select ename, job, sal from emp limit z, 5;
end $
delimiter ;


drop procedure if exists pro1;
delimiter $
create procedure pro1(in x int, in y int)
begin 

	select ename, job, sal from emp limit x, y;
end $
delimiter ;




drop procedure if exists pro1;
delimiter $
create procedure pro1()
begin 
	declare exit handler for 1136 select 'Invalid number of values....';
insert into dept(deptno, dname) values(52, 32);
	
end $
delimiter ;



drop procedure if exists pro1;
delimiter $
create procedure pro1(in x int, in y varchar(20))
begin 
	declare exit handler for 1062 select 'Check deptno number';
	if x < 80 then
		insert into dept(deptno, dname) values(x, y);
	ELSE
		select 'Invalid deptno';
	end if;
	
end $
delimiter ;




drop procedure if exists pro1;
delimiter $
create procedure pro1(in x int)
begin 
	DEClare flag bool default true;
	if flag = (select distinct true from emp where deptno=x)  THEN
		select ename, job, deptno from emp where deptno=x;
	ELSE
		select 'Not found';
	end if;
end $
delimiter ;






drop procedure if exists pro1;
delimiter $
create procedure pro1()
begin 
	create table  qq(c1 int);
end $
delimiter ;


drop procedure if exists pro1;
delimiter $
create procedure pro1()
begin 
	drop table  qq;
end $
delimiter ;




drop procedure if exists pro1;
delimiter $
create procedure pro1()
begin 
	
	prepare x from 'select ename, job from emp';
	execute x;

end $
delimiter ;


drop procedure if exists pro1;
delimiter $
create procedure pro1( in y varchar(64))
begin 
	
	set @x := concat('select * from ', y);
	prepare stat  from @x;
	execute stat;

end $
delimiter ;


drop procedure if exists pro1;
delimiter $
create procedure pro1(in c varchar(1000), in t varchar(1000))
begin 
	
	set @x := concat("select ", c , " from ", t);
	prepare stat  from @x;
	execute stat;

end $
delimiter ;


drop procedure if exists pro1;
delimiter $
create procedure pro1(in _dname varchar(20))
b1:begin 
	
	if (select true from dept where dname=_dname)then
		b2:begin
			
			declare c1 cursor for select ename, job,deptno from emp;
			
		end b2;
	ELSE
		select "Bad";
	end if;
	

end b1 $
delimiter ;






drop procedure if exists pro1;
delimiter $
create procedure pro1(in a int)
b1:begin 
		
	if a = 1000 then
		b2:begin
			select "True";
		end b2;
	else
		b3:begin
			select "False";
		end b3;
	end if;
	
end b1$
delimiter ;



drop procedure if exists pro1;
delimiter $
create procedure pro1()
b1:begin 
   declare _deptno int;
   declare _ename, _job varchar(30);
   
  declare c1 cursor  for select ename, job, deptno from emp;
  declare exit handler for 1329 select 'No data in cursor';
  open c1;
	loop
		fetch c1 into _ename, _job, _deptno;
		if _deptno = 10 then
			insert into y10 values(_ename, _job, _deptno);
		elseif	_deptno = 20 then
			insert into y20 values(_ename, _job, _deptno);
		else 
			select  'nither 10 or 20';
		end if;
		
	end loop;
  close c1;
end b1$
delimiter ;



drop procedure if exists pro1;
delimiter $
create procedure pro1(in a varchar(20))
b1:begin 
	declare x int;
	
	select distinct deptno into x from dept where dname=a;
	
	if x is null then
		select 'Not data found';
	else
		b2:begin
			declare _ename, _job varchar(20);
			declare  _deptno int;
			
			declare c1 cursor for select ename, job, deptno from emp where deptno = x;
			
			declare exit handler for 1329 select 'No data in cursor';
			
			open c1;
				loop
					fetch c1 into _ename, _job,_deptno  ;
					select _ename, _job,_deptno ;
				end loop;
			close c1;
		end b2;
	end if;
	
end b1$
delimiter ;

call pro1('abc');
call pro1('sales');




drop procedure if exists pro1;
delimiter $
create procedure pro1()
b1:begin 
	
	declare ex condition for sqlstate '45000';
 
	if 10 = 10 then
			signal ex set message_text = 'Okay';
	ELSE
		select "Good";	
end if;	
	select 'Out of IF...';
end b1 $
delimiter ;


drop function if exists f1;
delimiter $
create function f1() returns varchar(100)
deterministic
b1:begin 
	declare x varchar(100);
	select 'Hello World.. by saleel'  into x;
	return x;
end b1 $
delimiter ;

drop procedure if exists display;
delimiter $
create procedure display()
b1:begin 
	select f1();
end b1 $
delimiter ;



drop function if exists f1;
delimiter $
create function f1(x int, y int) returns int
deterministic
b1:begin 
	return ifnull(x,0) + ifnull(y,0);
end b1 $
delimiter ;


drop function if exists f1;
delimiter $
create function f1(x int) returns varchar(100)
deterministic
b1:begin 
	insert into g values(x);
	return 'Data inserted..';
	
end b1 $
delimiter ;


drop function if exists f1;
delimiter $
create function f1() returns varchar(100)
deterministic
b1:begin 
	create table g3(c1 int);
	return 'Table Created..';
	
end b1 $
delimiter ;



DROP FUNCTION IF EXISTS f1;
delimiter $$
CREATE FUNCTION f1(x varchar(20)) RETURNS varchar(30)
DETERMINISTIC
begin
  return CONCAT(UPPER(LEFT(x,1)), SUBSTR(LOWER(x), 2 ));
end $$
delimiter ;




DROP FUNCTION IF EXISTS f1;
delimiter $
CREATE FUNCTION f1() RETURNS VARCHAR(40)
deterministic
begin
    declare x, y, z VARCHAR(40) default "";
    declare cnt INT default 1;
    lbl:loop
       SELECT CAST(CHAR(FLOOR(65 + RAND() * 27)) as CHAR) INTO y;
       SELECT CAST(CHAR(FLOOR( 97 + RAND() * 27)) as CHAR) INTO z;
       SET x := CONCAT(x, y, z);
       if cnt > 2 then
          leave lbl;
       end if;
       SET cnt := cnt + 1;
    end loop lbl;
    return(x);
end $
delimiter ;





drop trigger if exists tr1;
delimiter $
create trigger tr1 before insert on dept for each ROW
begin
	select 'Hello World...  by saleel' into @x;
end $
delimiter ;



DROP FUNCTION IF EXISTS f1;
delimiter $$
CREATE FUNCTION f1() returns int
DETERMINISTIC
begin
  return (select max(deptno) + 1 from dept);
end $$
delimiter ;

drop trigger if exists tr1;
delimiter $
create trigger tr1 after insert on dept for each ROW
begin
	select count(*) into @x from dept;
end $
delimiter ;
*/
/*MYSQL> insert into dept values(51,'HRD','baroda','sam3r3', '24/10/2024');

new.deptno := 51, new.dname := 'HRD',....., new.startedon:= '24/10/2024'
*/

/*
drop trigger if exists tr1;
delimiter $
create trigger tr1 before delete on dept for each ROW
begin
	insert into d1 values(old.deptno, old.dname, old.loc, old.pwd, old.startedon, now(), user());
end $
delimiter ;



drop trigger if exists tr1;
delimiter $
create trigger tr1 before insert on dept for each ROW
begin
	set new.dname := upper(new.dname);
end $
delimiter ;

*/
/*MYSQL> insert into dept(deptno,dname) values(f1(),'abc');   ABC

new.deptno := f1()
new.dname := 'abc'    ABC
*/

drop trigger if exists tr1;
delimiter $
create trigger tr1 before insert on dept for each ROW
begin
	if dayname(curdate()) = 'Thursday' then
		signal sqlstate '42000' set message_text = 'Invalid Day';
	end if;
end $
delimiter ;