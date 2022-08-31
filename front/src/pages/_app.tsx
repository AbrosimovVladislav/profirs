import { MantineProvider } from '@mantine/core'
import type { AppProps } from 'next/app'
import useMantineTheme from '../config/useTheme'

function MyApp({ Component, pageProps }: AppProps) {
    const themeConfig = useMantineTheme()

    return (
        <MantineProvider withGlobalStyles withNormalizeCSS theme={themeConfig}>
            <Component {...pageProps} />
        </MantineProvider>
    )
}

export default MyApp
