-- we don't know how to generate root <with-no-name> (class Root) :(
create table "user"
(
	user_id integer not null
		constraint user_pkey
			primary key
		constraint user_id_key
			unique,
	username text not null,
	password text not null,
	access_level integer not null
);

alter table "user" owner to postgres;

create table employee
(
	name text not null,
	surname text not null,
	employee_id integer not null
		constraint employee_pkey
			primary key
		constraint "emp -> user"
			references "user"
);

alter table employee owner to postgres;

create table task
(
	status char(12),
	task_id integer not null
		constraint "Task_pkey"
			primary key
		constraint "Task -> emp"
			references employee,
	quantity smallint,
	done smallint,
	name text not null,
	index text not null,
	piority text
);

alter table task owner to postgres;

create table departments
(
	dep_id integer not null
		constraint departments_pkey
			primary key
		constraint departments_id_key
			unique
		constraint "dep -> emp"
			references employee,
	name text
);

alter table departments owner to postgres;

create table suppliers
(
	supplier_id integer not null
		constraint suppliers_pkey
			primary key,
	company_name text not null
);

alter table suppliers owner to postgres;

create table supply
(
	supply_id integer not null
		constraint supply_pkey
			primary key,
	metallic_materials integer not null,
	wooden_materials integer not null,
	composites integer not null,
	marble integer not null,
	stone_materials integer not null
);

alter table supply owner to postgres;

