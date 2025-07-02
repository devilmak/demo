
export default {
  bootstrap: () => import('./main.server.mjs').then(m => m.default),
  inlineCriticalCss: true,
  baseHref: '/',
  locale: undefined,
  routes: [
  {
    "renderMode": 2,
    "route": "/"
  },
  {
    "renderMode": 2,
    "route": "/forgot-account"
  },
  {
    "renderMode": 2,
    "route": "/create-account"
  },
  {
    "renderMode": 2,
    "route": "/world-map"
  }
],
  entryPointToBrowserMapping: undefined,
  assets: {
    'index.csr.html': {size: 5667, hash: '14c9fd031cc3aab584ea0a82d9fde652c4244b549534c5e58c6d5d9f6ab650df', text: () => import('./assets-chunks/index_csr_html.mjs').then(m => m.default)},
    'index.server.html': {size: 945, hash: '21c23c0c554e3b74687edb879806c6295e895ca0d9af672e3a7d2032bda2e8e7', text: () => import('./assets-chunks/index_server_html.mjs').then(m => m.default)},
    'index.html': {size: 12246, hash: '5dce9618345c5bb70504c8bdb46b74f23ebdf924c72165f23569d54e2249ee24', text: () => import('./assets-chunks/index_html.mjs').then(m => m.default)},
    'forgot-account/index.html': {size: 7361, hash: 'f9bb40eef8ab98e6d700429a911d8ce07e51a05646ac1d7bf82c9b12984d2f21', text: () => import('./assets-chunks/forgot-account_index_html.mjs').then(m => m.default)},
    'world-map/index.html': {size: 10362, hash: 'ab6299c4ad63072ee4beba8799a860c8ddc8e897c5bbfcbd88dae0c5c9964dd0', text: () => import('./assets-chunks/world-map_index_html.mjs').then(m => m.default)},
    'create-account/index.html': {size: 13158, hash: 'a925c562340a59aa33969746cd96f93b2ee07365f17aee8dabdc1350124b9955', text: () => import('./assets-chunks/create-account_index_html.mjs').then(m => m.default)},
    'styles-XHARIKYB.css': {size: 39928, hash: 'LHHeptroMjI', text: () => import('./assets-chunks/styles-XHARIKYB_css.mjs').then(m => m.default)}
  },
};
