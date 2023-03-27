// This file allows you to provide custom React components
// to be used in MDX files. You can import and use any
// React component you want, including components from
// other libraries.
function H1({ children }) {
  return <h1>{children}</h1>;
}

function H2({ children }) {
  return <h2>{children}</h2>;
}

function H3({ children }) {
  return <h3>{children}</h3>;
}

function H4({ children }) {
  return <h4>{children}</h4>;
}

function H5({ children }) {
  return <h5>{children}</h5>;
}

export function useMDXComponents(components) {
  return { h1: H1, h2: H2, h3: H3, h4: H4, h5: H5, ...components };
}
