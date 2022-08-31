import type { NextPage } from 'next';
import Head from 'next/head';

const About: NextPage = () => {
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
      <span>About</span>
    </>
  );
};

export default About;
