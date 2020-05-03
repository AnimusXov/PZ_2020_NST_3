--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-05-03 17:43:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2856 (class 0 OID 16626)
-- Dependencies: 205
-- Data for Name: departments; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.departments (dep_id, name) VALUES (1, 'Ślusarnia');
INSERT INTO public.departments (dep_id, name) VALUES (2, 'Spawalnia');
INSERT INTO public.departments (dep_id, name) VALUES (3, 'tokarka');
INSERT INTO public.departments (dep_id, name) VALUES (4, 'Ślusarnia 2');
INSERT INTO public.departments (dep_id, name) VALUES (5, 'Spawalnia 2');
INSERT INTO public.departments (dep_id, name) VALUES (6, 'Tokarka 2');
INSERT INTO public.departments (dep_id, name) VALUES (7, 'Test Jakości
');
INSERT INTO public.departments (dep_id, name) VALUES (8, 'Dep8');
INSERT INTO public.departments (dep_id, name) VALUES (9, 'Dep9');
INSERT INTO public.departments (dep_id, name) VALUES (10, 'Dep10');


--
-- TOC entry 2854 (class 0 OID 16589)
-- Dependencies: 203
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."user" (user_id, username, password, access_level) VALUES (1, 'admin', '123456', 3);
INSERT INTO public."user" (user_id, username, password, access_level) VALUES (2, 'kierownik', 'haslo2', 2);
INSERT INTO public."user" (user_id, username, password, access_level) VALUES (3, 'pracownik1', 'haslo', 1);
INSERT INTO public."user" (user_id, username, password, access_level) VALUES (4, 'Kierownik2', 'haslo2', 2);
INSERT INTO public."user" (user_id, username, password, access_level) VALUES (5, 'pracownik3
', 'asdqwe123', 1);
INSERT INTO public."user" (user_id, username, password, access_level) VALUES (6, 'pracownik4
', 'qwerty123', 1);
INSERT INTO public."user" (user_id, username, password, access_level) VALUES (7, 'pracownik5', 'zxcqwe', 1);
INSERT INTO public."user" (user_id, username, password, access_level) VALUES (8, 'pracownik6', 'asdqwezxc', 1);
INSERT INTO public."user" (user_id, username, password, access_level) VALUES (9, 'Admin2', 'qazwsxedc', 3);
INSERT INTO public."user" (user_id, username, password, access_level) VALUES (10, 'pracownik7', 'qeadzx', 1);


--
-- TOC entry 2855 (class 0 OID 16603)
-- Dependencies: 204
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employee (name, surname, employee_id) VALUES ('Zoé', 'Madill', 1);
INSERT INTO public.employee (name, surname, employee_id) VALUES ('Göran', 'Dudny', 2);
INSERT INTO public.employee (name, surname, employee_id) VALUES ('Gwenaëlle', 'Loadsman', 3);
INSERT INTO public.employee (name, surname, employee_id) VALUES ('Marie-noël', 'Sorrie', 4);
INSERT INTO public.employee (name, surname, employee_id) VALUES ('Mahélie', 'Garland', 5);
INSERT INTO public.employee (name, surname, employee_id) VALUES ('Wá', 'Hague', 6);
INSERT INTO public.employee (name, surname, employee_id) VALUES ('Anaëlle', 'Cobbald', 7);
INSERT INTO public.employee (name, surname, employee_id) VALUES ('Almérinda', 'Holdforth', 8);
INSERT INTO public.employee (name, surname, employee_id) VALUES ('Görel', 'Yarmouth', 9);
INSERT INTO public.employee (name, surname, employee_id) VALUES ('Bénédicte', 'Sillis', 10);


--
-- TOC entry 2857 (class 0 OID 32969)
-- Dependencies: 206
-- Data for Name: suppliers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.suppliers (supplier_id, company_name) VALUES (1, 'Tromp, Hudson and Wilkinson');
INSERT INTO public.suppliers (supplier_id, company_name) VALUES (2, 'Cruickshank Inc');
INSERT INTO public.suppliers (supplier_id, company_name) VALUES (3, 'Cremin, Lesch and Paucek');
INSERT INTO public.suppliers (supplier_id, company_name) VALUES (4, 'Windler, Roob and Oberbrunner');
INSERT INTO public.suppliers (supplier_id, company_name) VALUES (5, 'Bayer, Reinger and Koelpin');
INSERT INTO public.suppliers (supplier_id, company_name) VALUES (6, 'Flatley-McDermott');
INSERT INTO public.suppliers (supplier_id, company_name) VALUES (7, 'Carroll, Bernier and Langosh');
INSERT INTO public.suppliers (supplier_id, company_name) VALUES (8, 'Dibbert, Braun and Keeling');
INSERT INTO public.suppliers (supplier_id, company_name) VALUES (9, 'Waelchi and Sons');
INSERT INTO public.suppliers (supplier_id, company_name) VALUES (10, 'King Inc');


--
-- TOC entry 2858 (class 0 OID 32977)
-- Dependencies: 207
-- Data for Name: supply; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.supply (supply_id, metallic_materials, wooden_materials, composites, marble, stone_materials) VALUES (1, 82, 372, 218, 907, 610);
INSERT INTO public.supply (supply_id, metallic_materials, wooden_materials, composites, marble, stone_materials) VALUES (2, 67, 157, 719, 790, 789);
INSERT INTO public.supply (supply_id, metallic_materials, wooden_materials, composites, marble, stone_materials) VALUES (3, 82, 500, 436, 484, 838);
INSERT INTO public.supply (supply_id, metallic_materials, wooden_materials, composites, marble, stone_materials) VALUES (4, 87, 533, 390, 203, 648);
INSERT INTO public.supply (supply_id, metallic_materials, wooden_materials, composites, marble, stone_materials) VALUES (5, 75, 792, 370, 749, 407);
INSERT INTO public.supply (supply_id, metallic_materials, wooden_materials, composites, marble, stone_materials) VALUES (6, 69, 497, 200, 635, 688);
INSERT INTO public.supply (supply_id, metallic_materials, wooden_materials, composites, marble, stone_materials) VALUES (7, 76, 344, 876, 172, 873);
INSERT INTO public.supply (supply_id, metallic_materials, wooden_materials, composites, marble, stone_materials) VALUES (8, 67, 225, 346, 755, 182);
INSERT INTO public.supply (supply_id, metallic_materials, wooden_materials, composites, marble, stone_materials) VALUES (9, 88, 131, 540, 625, 240);
INSERT INTO public.supply (supply_id, metallic_materials, wooden_materials, composites, marble, stone_materials) VALUES (10, 88, 231, 882, 876, 522);


--
-- TOC entry 2853 (class 0 OID 16581)
-- Dependencies: 202
-- Data for Name: task; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.task (status, task_id, quantity, done, name, index, piority) VALUES ('W Realizacji', 1, 100, 45, 'Prawy/Lewy Bok Półki', '12.INVO.1120/15', NULL);
INSERT INTO public.task (status, task_id, quantity, done, name, index, piority) VALUES ('W Realizacji', 2, 50, 20, 'Skos', '46.INNPL.1137/56', NULL);
INSERT INTO public.task (status, task_id, quantity, done, name, index, piority) VALUES ('W Realizacji', 3, 30, 20, 'Blacha Rozpórki', '73.INNRC.1198/94', NULL);
INSERT INTO public.task (status, task_id, quantity, done, name, index, piority) VALUES ('W Realizacji', 4, 5, 1, 'Łącznik Ramy A', '47.INNMP.1177/57', NULL);
INSERT INTO public.task (status, task_id, quantity, done, name, index, piority) VALUES ('Oczekuje    ', 5, 230, 0, 'Łacznik Ramy B', '21.INNCP.1125/72', NULL);
INSERT INTO public.task (status, task_id, quantity, done, name, index, piority) VALUES ('Oczekuje    ', 6, 43, 0, 'Blacha Rozpórki', '94.INNKE.1116/90', NULL);
INSERT INTO public.task (status, task_id, quantity, done, name, index, piority) VALUES ('Oczekuje    ', 7, 22, 0, 'Rynienka Hydera', '32.INNQY.1131/62', NULL);
INSERT INTO public.task (status, task_id, quantity, done, name, index, piority) VALUES ('Oczekuje    ', 8, 12, 0, 'Element do reaktora  termonuklearnego ', '91.INNXL.1163/85', NULL);
INSERT INTO public.task (status, task_id, quantity, done, name, index, piority) VALUES ('Zakończony  ', 9, 78, 78, 'Bok Headera (Prawy + Lewy)', '80.INNVM.1173/03', NULL);
INSERT INTO public.task (status, task_id, quantity, done, name, index, piority) VALUES ('Zakończony  ', 10, 65, 65, 'Skos', '56.INNCK.1146/56', NULL);


-- Completed on 2020-05-03 17:43:46

--
-- PostgreSQL database dump complete
--

