import { MantineProvider } from '@mantine/core';
import type { AppProps } from 'next/app';
import Layout from '../components/common/Layout';
import useMantineTheme from '../config/useTheme';

function MyApp({ Component, pageProps }: AppProps) {
    const themeConfig = useMantineTheme();

    return (
        <MantineProvider withGlobalStyles withNormalizeCSS theme={themeConfig}>
            <Layout>
                <Component {...pageProps} />
            </Layout>
        </MantineProvider>
    );
}

export default MyApp;
