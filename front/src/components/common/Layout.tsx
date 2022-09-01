import { Container, createStyles } from '@mantine/core';
import React from 'react';

import { Footer } from './Footer';
import { Header } from './Header';

type Props = {
  children: JSX.Element;
};

const Layout = ({ children }: Props) => {
  const useStyles = createStyles((theme) => ({
    wrapper: {
      minHeight: '100vh',
      display: 'flex',
      flexDirection: 'column',
    },
  }));
  const links = [
    {
      title: 'Categories',
      link: '/categories',
    },
    {
      title: 'Specialists',
      link: '/specialists',
    },
    {
      title: 'About',
      link: '/about',
    },
  ];

  const { classes, cx } = useStyles();

  return (
    <div className={cx(classes.wrapper)}>
      <Header links={links} />
      <main style={{ marginBottom: 'auto' }}>
        <Container>{children}</Container>
      </main>
      <Footer links={links} />
    </div>
  );
};

export default Layout;
