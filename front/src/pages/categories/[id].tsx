import React, {useEffect} from 'react';
import Head from 'next/head';
import type { NextPage } from 'next';
import {useGetQuestionsByCategoryId} from "../../hooks/useGetQuestionsByCategoryId";

const CategoryDetails: NextPage = () => {

    //ToDo add extracting of id from url??? here
    const id = 1;
    const {questions} = useGetQuestionsByCategoryId(1);

    //ToDo delete this after showing of questions
    useEffect(() => {
        console.log(questions)
    },[questions])

  return (
    <>
      <Head>
        <title>Profi.rs | Category name</title>
        <meta
          name="description"
          content="Platform for finding any service you need."
        />
        <meta name="keywords" content="service, tutors" />
      </Head>

      <div>CategoryDetails</div>
    </>
  );
};

export default CategoryDetails;
