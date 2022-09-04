import type { NextPage } from 'next';
import Head from 'next/head';
import {useEffect} from "react";
import {useGetSpecialistsByCategoryId} from "../hooks/useGetSpecialistsByCategoryId";

const Specialists: NextPage = () => {

    //ToDo add extracting of id from url??? here
    const id = 1;
    const {specialists} = useGetSpecialistsByCategoryId(id);

    //ToDo delete this after showing of specialists
    useEffect(() => {
        console.log(specialists)
    },[specialists])

  return (
    <>
      <Head>
        <title>Profi.rs</title>
        <meta
          name="description"
          content="Platform for finding any service you need."
        />
        <meta name="keywords" content="service, tutors" />
      </Head>
      <span>Specialists</span>
    </>
  );
};

export default Specialists;
