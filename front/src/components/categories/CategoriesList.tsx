import { Grid } from '@mantine/core';
import React from 'react';
import ListWithTitle from '../common/ListWithTitle';

import { footerSections } from '../../data/data';

const CategoriesList = () => {
  return (
    <Grid gutter="md">
      {footerSections.map((el) => (
        <Grid.Col span={6} lg={3} key={el.id}>
          <ListWithTitle title={el.title} sections={el.children} />
        </Grid.Col>
      ))}
    </Grid>
  );
};

export default CategoriesList;
