import React from 'react';
import { Text, createStyles } from '@mantine/core';
import Link from 'next/link';

type Props = {
  category: any;
  title: string;
};

interface Item {
  id: Number;
  title: String;
  link?: String;
  children?: any[];
}

const ListWithTitle = ({ title, category }: Props) => {
  const useStyles = createStyles((theme) => ({
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

  const links = category?.children.slice(0, 4).map((item: Item, idx: any) => {
    return (
      <Link key={idx} href={item.link ? `${item.link}` : ``}>
        <Text className={classes.link}>{item.title}</Text>
      </Link>
    );
  });

  return (
    <div>
      <Link href={category?.link ? `${category.link}` : ``}>
        <Text
          variant="link"
          sx={{ cursor: 'pointer' }}
          className={classes.title}>
          {title}
        </Text>
      </Link>
      {links}
      <Link href={category?.link ? `${category.link}` : ``}>
        <Text variant="link" sx={{ cursor: 'pointer' }}>
          See all services ({`${category?.children?.length}`})
        </Text>
      </Link>
    </div>
  );
};

export default ListWithTitle;
