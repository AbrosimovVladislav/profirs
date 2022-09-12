import { Grid } from '@mantine/core';
import React from 'react';
import ListWithTitle from '../common/ListWithTitle';
import {useGetCategories} from "../../hooks/useGetCategories";

const CategoriesList = () => {
  const { categories } = useGetCategories();

  return (
      <Grid gutter="md">
        {categories.map(category => (
            <Grid.Col span={6} lg={3} key={category.id}>
              <ListWithTitle title={category.title} sections={category.children}/>
            </Grid.Col>
        ))}
      </Grid>
  );
};

export default CategoriesList;
