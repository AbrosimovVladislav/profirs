import type { NextPage } from 'next';
import Head from 'next/head';
import CategoriesList from '../../components/categories/CategoriesList';

const Categories: NextPage = () => {
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

      <CategoriesList />
    </>
  );
};

export default Categories;
