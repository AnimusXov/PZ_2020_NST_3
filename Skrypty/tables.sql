--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-05-03 17:50:33

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 205 (class 1259 OID 16626)
-- Name: departments; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.departments (
    dep_id integer NOT NULL,
    name text
);


--
-- TOC entry 204 (class 1259 OID 16603)
-- Name: employee; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.employee (
    name text NOT NULL,
    surname text NOT NULL,
    employee_id integer NOT NULL
);


--
-- TOC entry 206 (class 1259 OID 32969)
-- Name: suppliers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.suppliers (
    supplier_id integer NOT NULL,
    company_name text NOT NULL
);


--
-- TOC entry 207 (class 1259 OID 32977)
-- Name: supply; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.supply (
    supply_id integer NOT NULL,
    metallic_materials integer NOT NULL,
    wooden_materials integer NOT NULL,
    composites integer NOT NULL,
    marble integer NOT NULL,
    stone_materials integer NOT NULL
);


--
-- TOC entry 202 (class 1259 OID 16581)
-- Name: task; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.task (
    status character(12),
    task_id integer NOT NULL,
    quantity smallint,
    done smallint,
    name text NOT NULL,
    index text NOT NULL,
    piority text
);


--
-- TOC entry 203 (class 1259 OID 16589)
-- Name: user; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."user" (
    user_id integer NOT NULL,
    username text NOT NULL,
    password text NOT NULL,
    access_level integer NOT NULL
);


--
-- TOC entry 2711 (class 2606 OID 16588)
-- Name: task Task_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.task
    ADD CONSTRAINT "Task_pkey" PRIMARY KEY (task_id);


--
-- TOC entry 2719 (class 2606 OID 16646)
-- Name: departments departments_id_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.departments
    ADD CONSTRAINT departments_id_key UNIQUE (dep_id);


--
-- TOC entry 2721 (class 2606 OID 32965)
-- Name: departments departments_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.departments
    ADD CONSTRAINT departments_pkey PRIMARY KEY (dep_id);


--
-- TOC entry 2717 (class 2606 OID 16637)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 2723 (class 2606 OID 32976)
-- Name: suppliers suppliers_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.suppliers
    ADD CONSTRAINT suppliers_pkey PRIMARY KEY (supplier_id);


--
-- TOC entry 2725 (class 2606 OID 32981)
-- Name: supply supply_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.supply
    ADD CONSTRAINT supply_pkey PRIMARY KEY (supply_id);


--
-- TOC entry 2713 (class 2606 OID 16639)
-- Name: user user_id_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_id_key UNIQUE (user_id);


--
-- TOC entry 2715 (class 2606 OID 57552)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2726 (class 2606 OID 16640)
-- Name: employee emp -> user; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT "emp -> user" FOREIGN KEY (employee_id) REFERENCES public."user"(user_id) NOT VALID;


-- Completed on 2020-05-03 17:50:34

--
-- PostgreSQL database dump complete
--

