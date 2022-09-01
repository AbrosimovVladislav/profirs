import React from 'react';
import { Text, createStyles } from '@mantine/core';
import Link from 'next/link';

type Props = {
  sections: any;
  title: string;
};

interface Item {
  id: Number;
  title: String;
  link?: String;
  children?: any[];
}

const ListWithTitle = ({ sections, title }: Props) => {
  const useStyles = createStyles((theme) => ({
    wrapper: {
      width: 160,
    },

    link: {
      display: 'block',
      color:
        theme.colorScheme === 'dark'
          ? theme.colors.dark[1]
          : theme.colors.gray[6],
      fontSize: theme.fontSizes.md,
      paddingTop: 3,
      paddingBottom: 3,
      cursor: 'pointer',

      '&:hover': {
        textDecoration: 'underline',
      },
    },

    title: {
      fontSize: theme.fontSizes.xl,
      fontWeight: 700,
      fontFamily: `Greycliff CF, ${theme.fontFamily}`,
      marginBottom: theme.spacing.xs / 2,
      color: theme.colorScheme === 'dark' ? theme.white : theme.black,
    },
  }));

  const { classes } = useStyles();

  const links = sections?.map((item: Item, idx: any) => {
    return (
      <Link
        key={idx}
        href={item.link ? `${item.link}` : `categories/${item.id}`}>
        <Text className={classes.link}>{item.title}</Text>
      </Link>
    );
  });

  return (
    <div className={classes.wrapper}>
      <Text className={classes.title}>{title}</Text>
      {links}
    </div>
  );
};

export default ListWithTitle;
