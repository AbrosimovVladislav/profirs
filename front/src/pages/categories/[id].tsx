import React from 'react';
import Head from 'next/head';
import type { NextPage } from 'next';

const CategoryDetails: NextPage = () => {
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
