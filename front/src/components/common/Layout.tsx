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
      link: '/specialists',
      label: 'Specialists',
    },
    {
      link: '/about',
      label: 'About',
    },
  ];

  const footerSections = [
    {
      title: 'Pages',
      links: links,
    },
    {
      title: 'Sections',
      links: links,
    },
  ];
  const { classes, cx } = useStyles();

  return (
    <div className={cx(classes.wrapper)}>
      <Header links={links} />
      <main style={{ marginBottom: 'auto' }}>
        <Container>{children}</Container>
      </main>
      <Footer data={footerSections} />
    </div>
  );
};

export default Layout;
